import { Move } from "./Move";
import { Bishop } from "./Pieces/Bishop";
import { BlackPawn } from "./Pieces/BlackPawn";
import { ChessPiece } from "./Pieces/ChessPiece";
import { King } from "./Pieces/King";
import { Knight } from "./Pieces/Knight";
import { Piece, PieceType } from "./Pieces/Piece"
import { Queen } from "./Pieces/Queen";
import { Rook } from "./Pieces/Rook";
import { WhitePawn } from "./Pieces/WhitePawn";
import { Position } from "./Position"

export interface Board {

    allSquares: Piece[][];

    isWhiteTurn: boolean;
    // wKingSideCastle : boolean;
    // wQueenSideCastle: boolean;
    // bKingSideCastle : boolean;
    // bQueenSideCastle: boolean;

    // fiftyMoveCount : number;
    // enPassantCaptureLoc : Position;

    makeMove: (this: Board, toMake: Move) => Board;
    pieceAt: (loc: Position) => Piece;
    generateMoves: () => Move[];
}


export class ChessBoard implements Board {

    isWhiteTurn: boolean = true;

    //TODO: capture this in the copy constructor at some point...

    allSquares: Piece[][];

    //  rnbqkbnr        7
    //  pppppppp        6
    //  ........        5
    //  ........        4
    //  ........        3
    //  ........        2
    //  PPPPPPPP        1
    //  RNBQKBNR        0

    //  01234567

    pieceAt(loc: Position): Piece {

        return this.allSquares[loc.row][loc.col];
    }


    constructor(copyFrom?: ChessBoard) {
        if (copyFrom) {
            this.buildFrom(copyFrom);
        } else {
            this.allSquares = [];
            for (let row = 0; row < 8; row++) {
                this.allSquares[row] = [];
                for (let col = 0; col < 8; col++) {
                    // if( row === 6 ){
                    //     this.allSquares[row][col] = {kind: PieceType.Pawn, isWhite: false};
                    // }
                    // if( row === 1 ){
                    //     this.allSquares[row][col] = {kind: PieceType.Pawn, isWhite: true};
                    // }

                    // if( row === 1 || row === 6 ){
                    //     this.allSquares[row][col] =  row === 1 ? new WhitePawn() : new BlackPawn();
                    // }

                    if ((row === 0 || row === 7) && (col === 0 || col === 7)) {
                        this.allSquares[row][col] = new Rook(row === 0);
                    }

                    if ((row === 0 || row === 7) && (col === 1 || col === 6)) {
                        this.allSquares[row][col] = new Knight(row === 0);
                    }

                    if ((row === 0 || row === 7) && (col === 2 || col === 5)) {
                        this.allSquares[row][col] = new Bishop(row === 0);
                    }

                    if (col === 3 && (row === 0 || row === 7)) {
                        this.allSquares[row][col] = new Queen(row === 0);
                    }

                    if (col === 4 && (row === 0 || row === 7)) {
                        this.allSquares[row][col] = new King(row === 0);
                    }

                    if (!this.allSquares[row][col]) {

                        this.allSquares[row][col] = null;
                    }

                }
            }
        }
        // this.allSquares[2][1] = new Queen(false);
        // this.allSquares[2][3] = new BlackPawn();
    }
    // isWhiteTurn: boolean;
    // wKingSideCastle: boolean;
    // wQueenSideCastle: boolean;
    // bKingSideCastle: boolean;
    // bQueenSideCastle: boolean;

    buildFrom(toCopy: Board) {

        // [a, b, c]
        // [[a, b, c]]

        this.allSquares = [];
        for (let i = 0; i < toCopy.allSquares.length; i++) {
            this.allSquares.push([...toCopy.allSquares[i]]);
        }
    }


    makeMove: (toMake: Move) => Board = toMake => {

        //TODO: enpassant stuff
        //TODO: 50 move rule stuff

        let nextBoard: ChessBoard = new ChessBoard(this);


        let oldPiece: Piece = nextBoard.allSquares[toMake.from.row][toMake.from.col];

        nextBoard.allSquares[toMake.from.row][toMake.from.col] = null;
        nextBoard.allSquares[toMake.to.row][toMake.to.col] = oldPiece;
        nextBoard.isWhiteTurn = !this.isWhiteTurn;



        return nextBoard;
    }

    generateMoves(): Move[] {

        let allMoves: Move[] = [];

        for (let row = 0; row < 8; row++) {
            for (let col = 0; col < 8; col++) {
                if (this.allSquares[row][col]) {
                    allMoves.push(...this.allSquares[row][col].generateMoves(this, { row, col }))
                }
            }
        }

        return allMoves;
    }
}


console.log("attempting to create a board")
let testBoard: Board = new ChessBoard();
console.log("done creating a board:");
//console.log( testBoard );

//moving pawn out of the way for bishop
//testBoard = testBoard.makeMove( { from: {row: 1, col: 3}, to: {row: 3, col: 3} } );

//moving pawn out of the way for rook
//testBoard = testBoard.makeMove( { from: {row: 1, col: 0}, to: {row: 0, col: 5}})

// testBoard = testBoard.makeMove( {from: {row: 1, col: 3}, to: {row: 3, col: 3}})
// testBoard = testBoard.makeMove( {from: {row: 1, col: 2}, to: {row: 3, col: 2}})
// testBoard = testBoard.makeMove( {from: {row: 1, col: 4}, to: {row: 3, col: 4}})
// console.log(ChessBoard.toString2dArray(testBoard.allSquares));
// console.log(testBoard.allSquares)
