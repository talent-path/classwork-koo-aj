import { Board } from "../Board";
import { Move } from "../Move";
import { Position } from "../Position";
import { ChessPiece } from "./ChessPiece";
import { PieceType } from "./Piece";

export class Knight extends ChessPiece {

    constructor( isWhite : boolean ){
        super( PieceType.Knight, isWhite );
    }

    generateMoves: (moveOn: Board, loc: Position) => Move[] = 
    (moveOn: Board, loc: Position)  => {
        let knightsMoves : Move[]  = [];

        let knightsDirections : Position[] = [];

            // first we know that the first move that the pawn can make is 1 or 2
            // after the first move it cannot go two but ONLY 1
            // we must check if the diagonal down has a piece that we can capture
            // if it goes all the way to the row we can switch to a desired pieace.
            
            
            knightsDirections.push( {row : 2, col: -1} );
            knightsDirections.push( {row : 2, col: 1} );
            knightsDirections.push( {row : 1, col: -2});
            knightsDirections.push( {row : 1, col: 2});
            knightsDirections.push( {row : -2, col: -1} );
            knightsDirections.push( {row : -2, col: 1} );
            knightsDirections.push( {row : -1, col: -2});
            knightsDirections.push( {row : -1, col: 2});

            

            for( let direction of knightsDirections ){
                let directionMoves : Move[] = Knight.jumpPiece( moveOn, loc, direction, this.isWhite );
                knightsMoves.push( ...directionMoves );
            }

            return knightsMoves;
    }


    // xxxx
    // xxxx
    // xxxp
    // xxpr
    static jumpPiece: (moveOn : Board, loc : Position, dir : Position, isWhite : boolean ) =>  Move[] = 
        ( moveOn : Board, loc : Position, dir : Position, isWhite: boolean ) : Move[] => {

            let allMoves : Move[] = [];

            let currentLoc : Position = { row : loc.row + dir.row, col : loc.col + dir.col };

            
            if (Knight.isOnBoard( currentLoc ) && moveOn.pieceAt(currentLoc) === null){
                allMoves.push( { from: loc, to: currentLoc  });
            }

            if(Knight.isOnBoard( currentLoc ) && moveOn.pieceAt(currentLoc) !== null){
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