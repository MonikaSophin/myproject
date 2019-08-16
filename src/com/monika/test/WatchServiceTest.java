package com.monika.test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * 使用watchservice监听文件动作
 * @author Administrator
 *
 */
public class WatchServiceTest {

	public static void main(String[] args) throws IOException {
		String uri = "d:/";
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Path path = Paths.get(uri);
		path.register(watchService, 
				StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {  
					while(true){  
						WatchKey watchKey = watchService.take();  
						List<WatchEvent<?>> watchEvents = watchKey.pollEvents();  
						for(WatchEvent<?> event : watchEvents){  
							//TODO 根据事件类型采取不同的操作。。。。。。。  
							System.out.println("["+path+"\\"+event.context()+"]文件发生了["+event.kind()+"]事件");    
						}  
						watchKey.reset();  
					}  
				} catch (InterruptedException e) {  
					e.printStackTrace();  
				}
			}
		});

		//使用用户线程
		thread.setDaemon(false);
		thread.start();

		// 增加jvm关闭的钩子来关闭监听
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					watchService.close();
					System.out.println("watchservice已经关闭");
				} catch (Exception e) {
				
				}
			}
		}));
	}

}
