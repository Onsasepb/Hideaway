package com.example.hideaway.models

class Patient {
    var name:String = ""
    var age:String = ""
    var progres:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, age: String, progres: String, imageUrl: String, id: String) {
        this.name = name
        this.age = age
        this.progres = progres
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}