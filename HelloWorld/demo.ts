let boolVariable : boolean = false;
let numVariable : number = 50;
// let bigIntVariable : bigint = 5000000000000000000000n;

let stringVariable : string = "Bob";

let oldArray : number[] = [5,4,3,2,1]
let stringArr : string[] = ["hello", "world"]
let tupleVar : [number, string, boolean] ;
tupleVar = [5, "Bob", false]
tupleVar = [6, "AJ", true]

enum StreetLights {
    Red, Yellow, Green
}

let light : StreetLights = StreetLights.Green
// "any" basically puts us back in old 356 times
let anyVar : any = 5
anyVar = "Bob"
numVariable = anyVar

let objVariable : object = {}


interface TicTacToePlayer {
    name : string;
    turn : boolean;
}

function printPlayerName(player : TicTacToePlayer) : string {
    console.log(player.name)
    return player.name 
}

interface Student {
    studentId ?: number
    name : string 
}

let s : Student = {name : "David"}

let optionalVar : Partial<Student> = {}

optionalVar.name = "David"
optionalVar.studentId = 5
