package com.alexc.testhw.core

interface Initializer {
    fun init(){
        references()
        actions()
    }

    fun references()
    fun actions()
}