import { Component, Input, OnInit } from '@angular/core';
import { Bishop } from '../chess/Pieces/Bishop';
import { Piece, PieceType } from '../chess/Pieces/Piece';
import {Output, EventEmitter} from '@angular/core';
import { Position } from '../chess/Position';

@Component({
  selector: 'chess-square',
  templateUrl: './chess-square.component.html',
  styleUrls: ['./chess-square.component.css']
})

export class ChessSquareComponent implements OnInit {

  @Input()squarePiece : Piece = new Bishop(true);
  imgSrc: string = "./assets/";
  @Input()row: number = 1;
  @Input()col: number = 6;
  isLightSquare: boolean = true;
  @Output() squareClickedEvent : EventEmitter<Position> = new EventEmitter<Position>();

  constructor() {
    
  }

  ngOnInit(): void {
    console.log(this.squarePiece)
    if(this.squarePiece == null){
      this.imgSrc = "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNkYPhfDwAChwGA60e6kgAAAABJRU5ErkJggg==";
    } else{
      this.imgSrc += this.squarePiece.isWhite ? "w" : "b";
      switch (this.squarePiece.kind) {
        case PieceType.Bishop: this.imgSrc += "B"; break;
        case PieceType.Knight: this.imgSrc += "N"; break;
        case PieceType.Rook: this.imgSrc += "R"; break;
        case PieceType.Queen: this.imgSrc += "Q"; break;
        case PieceType.King: this.imgSrc += "K"; break;
        case PieceType.Pawn: this.imgSrc += "P"; break;
      }

    this.imgSrc += ".png";
    }


    this.isLightSquare = (this.row + this.col) % 2 === 0;
  }

  squareClicked() : void {
    this.squareClickedEvent.emit({row : this.row, col : this.col})
  }

}
