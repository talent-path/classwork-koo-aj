import { Position } from "./Position";

export class TicTacToeBoard  {
    allSquares: number[][];
    isXTurn: boolean;
    gameOver : boolean;
    rows : number[];
    cols : number[];
    diag: number;
    antiDiag : number;
    
    constructor(copyFrom ?: TicTacToeBoard, turn ?: boolean, 
        gameOver ?: boolean, rows ?: number[], cols ?: number[]
        , diag ?: number, antiDiag ?: number) {
        if(copyFrom) {
            this.allSquares = [];
            this.isXTurn = turn;
            this.gameOver = gameOver;
            this.rows = rows;
            this.cols = cols;
            this.diag = diag;
            this.antiDiag = antiDiag;
        }
        else {
            this.allSquares = [];
            this.isXTurn = true;
            this.gameOver = false;
            this.rows = [0, 0, 0];
            this.cols = [0, 0, 0];
            this.diag = 0;
            this.antiDiag = 0;
            for(let row = 0; row < 3; row++) {
                this.allSquares[row] = [];
                for(let col = 0; col < 3; col++) {
                    this.allSquares[row][col] = 0;
                }
            }
        }
    }

    placeMove(toPlace : Position) : void {
        let won : boolean = false;
        if (this.isXTurn) {
            this.addPiece(1, toPlace);
            this.allSquares[toPlace.row][toPlace.col] = 1;
            won = this.checkWin(this.allSquares, toPlace);
        }
        else {
            this.addPiece(-1, toPlace);
            this.allSquares[toPlace.row][toPlace.col] = -1;
            won = this.checkWin(this.allSquares, toPlace);
        }
        if (won) {
            this.gameOver = true;
            let player : string = "";
            if (this.isXTurn) player = "X";
            else player = "O";
            console.log("Player " + player + " wins!");
        }
        this.isXTurn = !this.isXTurn;
    }

    addPiece(p : number, toPlace : Position) {
        this.rows[toPlace.row] += p;
        this.cols[toPlace.col] += p;
        // console.log(this.rows);
        // console.log(this.cols);
        if(toPlace.row === toPlace.col)
            this.diag += p;
        if(toPlace.row + toPlace.col === 2)
            this.antiDiag += p;
    }

    checkWin(board: number[][], current : Position) : boolean {
        if (Math.abs(this.rows[current.row]) === 3 ||
                Math.abs(this.cols[current.col]) === 3 ||
                Math.abs(this.diag) === 3 ||
                Math.abs(this.antiDiag) === 3) {
            return true;
        }
        return false;
    }

}