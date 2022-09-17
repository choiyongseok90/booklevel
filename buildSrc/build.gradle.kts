repositories {
    //gradle plugin(library) 저장소. mavenCentral과 연동되어있음.
    jcenter()
}
plugins {
    //kotlin으로 gradle을 구성하기 위한 내부 활용 언어. build.gradle.kts 에서 활용되는 코틀린 문법이다.
    `kotlin-dsl`
}
kotlinDslPluginOptions {
    experimentalWarning.set(false)
}