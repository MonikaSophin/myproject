#include "jni.h"
#include "com_jni_JNITest.h"

//#include otherheaders

JNIEXPORT void JNICALL Java_com_jni_JNITest_test
  (JNIEnv *env, jobject jj)
{
printf("jni test success!\n");
return;
}
