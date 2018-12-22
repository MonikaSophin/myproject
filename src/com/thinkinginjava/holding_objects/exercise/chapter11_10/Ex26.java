package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import com.thinkinginjava.holding_objects.example.chapter11_9.TextFile;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/20 23:05
 * @Version: 1.0
 * @Description: page 236
 * 练习26：拿到前一个练习中所产生的Map,并按照它们在最初的文件中出现的顺序重新
 * 创建单词顺序。
 */
public class Ex26 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> m =
                new LinkedHashMap<>();
        List<String> words = new LinkedList<>();
        words.addAll(new TextFile("src\\com\\thinkinginjava\\holding_objects\\example\\chapter11_9\\SetOperations.java", "\\W+"));
        System.out.println("Words in file: " + words);
        Iterator itWords = words.iterator();
        int count = 0;
        while(itWords.hasNext()) {
            String s = (String)itWords.next();
            count++;
            if(!m.keySet().contains(s)) {
                ArrayList<Integer> ai =
                        new ArrayList<>();
                ai.add(0, count);
                m.put(s, ai);
            }
            else {
                m.get(s).add(count);
                m.put(s, m.get(s));
            }
        }
        System.out.println();
        System.out.println("Map of word locations: " + m);
        // New Map to hold sorted words, keyed by location:
        Map<Integer,String> replay = new TreeMap<>();
        Iterator<Map.Entry<String,ArrayList<Integer>>> it =
                m.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String,ArrayList<Integer>> me = it.next();
            for(int i = 0; i < me.getValue().size(); i++)
                replay.put(me.getValue().get(i),
                        me.getKey());
        }
        System.out.println();
        System.out.println("TreeMap of ordered locations, words: " + replay);
        System.out.println();
        // Display words in order as TreeMap values():
        System.out.println("Words in original order: " +
                replay.values());
    }
}
/**output:
 * Words in file: [package, com, thinkinginjava, holding_objects, example, chapter11_9, import, java, util, public, class, SetOperations, public, static, void, main, String, args, Set, String, set1, new, HashSet, String, Collections, addAll, set1, A, B, C, D, E, F, G, H, I, J, K, L, split, set1, add, M, System, out, println, H, set1, contains, H, System, out, println, N, set1, contains, N, Set, String, set2, new, HashSet, String, Collections, addAll, set2, H, I, J, K, L, split, System, out, println, set2, in, set1, set1, containsAll, set2, set1, remove, H, System, out, println, set1, set1, System, out, println, set2, in, set1, set1, containsAll, set2, set1, removeAll, set2, System, out, println, set2, removed, from, set1, set1, Collections, addAll, set1, X, Y, Z, split, System, out, println, X, Y, Z, added, to, set1, set1, Output, H, true, N, false, set2, in, set1, true, set1, D, K, C, B, L, G, I, M, A, F, J, E, set2, in, set1, false, set2, removed, from, set1, D, C, B, G, M, A, F, E, X, Y, Z, added, to, set1, Z, D, C, B, G, M, A, F, Y, X, E]
 *
 * Map of word locations: {package=[1], com=[2], thinkinginjava=[3], holding_objects=[4], example=[5], chapter11_9=[6], import=[7], java=[8], util=[9], public=[10, 13], class=[11], SetOperations=[12], static=[14], void=[15], main=[16], String=[17, 20, 24, 59, 63], args=[18], Set=[19, 58], set1=[21, 27, 41, 48, 55, 78, 79, 82, 88, 89, 95, 96, 99, 108, 109, 112, 125, 126, 134, 136, 151, 156, 170], new=[22, 61], HashSet=[23, 62], Collections=[25, 64, 110], addAll=[26, 65, 111], A=[28, 145, 162, 177], B=[29, 140, 159, 174], C=[30, 139, 158, 173], D=[31, 137, 157, 172], E=[32, 148, 164, 181], F=[33, 146, 163, 178], G=[34, 142, 160, 175], H=[35, 47, 50, 67, 84, 128], I=[36, 68, 143], J=[37, 69, 147], K=[38, 70, 138], L=[39, 71, 141], split=[40, 72, 116], add=[42], M=[43, 144, 161, 176], System=[44, 51, 73, 85, 90, 102, 117], out=[45, 52, 74, 86, 91, 103, 118], println=[46, 53, 75, 87, 92, 104, 119], contains=[49, 56], N=[54, 57, 130], set2=[60, 66, 76, 81, 93, 98, 101, 105, 132, 149, 153], in=[77, 94, 133, 150], containsAll=[80, 97], remove=[83], removeAll=[100], removed=[106, 154], from=[107, 155], X=[113, 120, 165, 180], Y=[114, 121, 166, 179], Z=[115, 122, 167, 171], added=[123, 168], to=[124, 169], Output=[127], true=[129, 135], false=[131, 152]}
 *
 * TreeMap of ordered locations, words: {1=package, 2=com, 3=thinkinginjava, 4=holding_objects, 5=example, 6=chapter11_9, 7=import, 8=java, 9=util, 10=public, 11=class, 12=SetOperations, 13=public, 14=static, 15=void, 16=main, 17=String, 18=args, 19=Set, 20=String, 21=set1, 22=new, 23=HashSet, 24=String, 25=Collections, 26=addAll, 27=set1, 28=A, 29=B, 30=C, 31=D, 32=E, 33=F, 34=G, 35=H, 36=I, 37=J, 38=K, 39=L, 40=split, 41=set1, 42=add, 43=M, 44=System, 45=out, 46=println, 47=H, 48=set1, 49=contains, 50=H, 51=System, 52=out, 53=println, 54=N, 55=set1, 56=contains, 57=N, 58=Set, 59=String, 60=set2, 61=new, 62=HashSet, 63=String, 64=Collections, 65=addAll, 66=set2, 67=H, 68=I, 69=J, 70=K, 71=L, 72=split, 73=System, 74=out, 75=println, 76=set2, 77=in, 78=set1, 79=set1, 80=containsAll, 81=set2, 82=set1, 83=remove, 84=H, 85=System, 86=out, 87=println, 88=set1, 89=set1, 90=System, 91=out, 92=println, 93=set2, 94=in, 95=set1, 96=set1, 97=containsAll, 98=set2, 99=set1, 100=removeAll, 101=set2, 102=System, 103=out, 104=println, 105=set2, 106=removed, 107=from, 108=set1, 109=set1, 110=Collections, 111=addAll, 112=set1, 113=X, 114=Y, 115=Z, 116=split, 117=System, 118=out, 119=println, 120=X, 121=Y, 122=Z, 123=added, 124=to, 125=set1, 126=set1, 127=Output, 128=H, 129=true, 130=N, 131=false, 132=set2, 133=in, 134=set1, 135=true, 136=set1, 137=D, 138=K, 139=C, 140=B, 141=L, 142=G, 143=I, 144=M, 145=A, 146=F, 147=J, 148=E, 149=set2, 150=in, 151=set1, 152=false, 153=set2, 154=removed, 155=from, 156=set1, 157=D, 158=C, 159=B, 160=G, 161=M, 162=A, 163=F, 164=E, 165=X, 166=Y, 167=Z, 168=added, 169=to, 170=set1, 171=Z, 172=D, 173=C, 174=B, 175=G, 176=M, 177=A, 178=F, 179=Y, 180=X, 181=E}
 *
 * Words in original order: [package, com, thinkinginjava, holding_objects, example, chapter11_9, import, java, util, public, class, SetOperations, public, static, void, main, String, args, Set, String, set1, new, HashSet, String, Collections, addAll, set1, A, B, C, D, E, F, G, H, I, J, K, L, split, set1, add, M, System, out, println, H, set1, contains, H, System, out, println, N, set1, contains, N, Set, String, set2, new, HashSet, String, Collections, addAll, set2, H, I, J, K, L, split, System, out, println, set2, in, set1, set1, containsAll, set2, set1, remove, H, System, out, println, set1, set1, System, out, println, set2, in, set1, set1, containsAll, set2, set1, removeAll, set2, System, out, println, set2, removed, from, set1, set1, Collections, addAll, set1, X, Y, Z, split, System, out, println, X, Y, Z, added, to, set1, set1, Output, H, true, N, false, set2, in, set1, true, set1, D, K, C, B, L, G, I, M, A, F, J, E, set2, in, set1, false, set2, removed, from, set1, D, C, B, G, M, A, F, E, X, Y, Z, added, to, set1, Z, D, C, B, G, M, A, F, Y, X, E]
 */