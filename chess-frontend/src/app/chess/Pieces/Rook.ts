import { Board } from "../Board";
import { Move } from "../Move";
import { Position } from "../Position";
import { ChessPiece } from "./ChessPiece";
import { PieceType } from "./Piece";
export class Rook extends ChessPiece {
    constructor( isWhite : boolean ){
        super( PieceType.Rook, isWhite );
    }
    
    generateMoves: (moveOn: Board, loc: Position) => Move[] = 
    (moveOn: Board, loc: Position)  => {
        // this is the Move array that we will push
        let rookMoves : Move[]  = [];
        // initializing an array of position(row, col)
        let rookDirections : Position[] = [];
        // xxrxx
        // xxrxx 
        // rrsrr starts at 2,2
        // xxrxx
        // xxrxx
        rookDirections.push( {row : 1, col: 0} );
        rookDirections.push( {row : 0, col: 1} );
        rookDirections.push( {row : -1, col: 0} );
        rookDirections.push( {row : 0, col: -1} );
        
        for( let direction of rookDirections ){
            let directionMoves : Move[] = Rook.slidePiece( moveOn, loc, direction, this.isWhite );
            rookMoves.push( ...directionMoves );
        }

        return rookMoves;
    }

    static slidePiece: (moveOn : Board, loc : Position, dir : Position, isWhite : boolean ) =>  Move[] = 
        ( moveOn : Board, loc : Position, dir : Position, isWhite: boolean ) : Move[] => {
            
            let allMoves : Move[] = [];

            let currentLoc : Position = { row : loc.row + dir.row, col : loc.col + dir.col };

            while( Rook.isOnBoard( currentLoc ) && moveOn.pieceAt(currentLoc) === null ){
                allMoves.push( { from: loc, to: currentLoc  });
                currentLoc = { row: currentLoc.row + dir.row, col : currentLoc.col + dir.col };
            }

            if( Rook.isOnBoard( currentLoc )){
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