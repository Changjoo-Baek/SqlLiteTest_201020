package com.zzazzu.sqllitetest_201020.Model

class Person {
    var id:Int=0
    var name:String?=null
    var email:String?=null

    constructor() {}

    constructor(id:Int, name:String, email:String){
        this.id=id
        this.name=name
        this.email=email
    }
}