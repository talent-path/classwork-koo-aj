import { Board } from "../Board";
import { Move } from "../Move";
import { Position } from "../Position";
import { ChessPiece } from "./ChessPiece";
import { PieceType } from "./Piece";

export class WhitePawn extends ChessPiece {

    constructor(){
        super(PieceType.Pawn, true);
    }

    generateMoves: (moveOn: Board, loc: Position) => Move[] = 
    (moveOn: Board, loc: Position)  => {

            
        let wPawnMoves : Move[]  = [];

            //we'll generate 4 "position" objects that represent different directions the bishop might move
            //then try those one at a time and add the results

            let wPawnDirections : Position[] = [];

            // first we know that the first move that the pawn can make is 1 or 2
            // after the first move it cannot go two but ONLY 1
            // we must check if the diagonal down has a piece that we can capture
            // if it goes all the way to the row we can switch to a desired pieace.
            const loc3 : Position = {row : (loc.row + 1), col : (loc.col)};
            if( moveOn.pieceAt(loc3) === null)
                wPawnDirections.push( {row : 1, col: 0} );
            
            if (loc.row === 1) 
                wPawnDirections.push( {row : 2, col: 0} );
            
            const loc1 : Position = {row : (loc.row + 1), col : (loc.col + 1)};
            const loc2 : Position = {row : (loc.row + 1), col : (loc.col - 1)};
            if (moveOn.pieceAt(loc1) !== null && moveOn.pieceAt(loc1) !== undefined && !moveOn.pieceAt(loc1).isWhite) // && IS NOT A BLACK PAWN
            wPawnDirections.push( {row : 1, col: 1});
            if (moveOn.pieceAt(loc2) !== null && moveOn.pieceAt(loc2) !== undefined && !moveOn.pieceAt(loc2).isWhite) // && IS NOT A BLACK PAWN
            wPawnDirections.push( {row : 1, col: -1});

            

            for( let direction of wPawnDirections ){
                let directionMoves : Move[] = WhitePawn.slidePiece( moveOn, loc, direction, this.isWhite );
                wPawnMoves.push( ...directionMoves );
            }

            return wPawnMoves;
    }

    static slidePiece: (moveOn : Board, loc : Position, dir : Position, isWhite : boolean ) =>  Move[] = 
    ( moveOn : Board, loc : Position, dir : Position, isWhite: boolean ) : Move[] => {

        let allMoves : Move[] = [];

        let currentLoc : Position = { row : loc.row + dir.row, col : loc.col + dir.col };

        
        if ( WhitePawn.isOnBoard( currentLoc ) && moveOn.pieceAt(currentLoc) === null ){
            allMoves.push( { from: loc, to: currentLoc  });
            currentLoc = { row: currentLoc.row + dir.row, col : currentLoc.col + dir.col };
        }

        if( moveOn.pieceAt(currentLoc) !== null && WhitePawn.isOnBoard( currentLoc )){
            if( moveOn.pieceAt(currentLoc).isWhite != isWhite  ){
                allMoves.push( {from: loc, to: currentLoc});
            }
        }

        return allMoves;
    }

    static isOnBoard( loc : Position ) : boolean {
        return loc.col >= 0 && loc.col < 8 && loc.row >= 0 && loc.row < 8;
    }
}