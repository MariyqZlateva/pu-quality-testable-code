package com.mariazlateva.puqualitytestablecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PuQualityTestableCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PuQualityTestableCodeApplication.class, args);
    }

}
// Да се разработи система за класиране на деца за детска градина.
// Системата ще има 3  вида участници: администратор, родители, деца.
// Класирането ще се осъществява по  точков принцип.
//        За всеки работещ родител по 1 точка.
//        За дете с увреждане 2 точки
//        За близнаци 1
//        За брат/сестра в детското заведение 1т.
//        При деца с еднакви точки класирането е на случаен принцип.
