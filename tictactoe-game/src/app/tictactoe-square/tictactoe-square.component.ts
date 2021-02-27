import { PipeCollector } from '@angular/compiler/src/template_parser/binding_parser';
import { EventEmitter } from '@angular/core';
import { Input, Output } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Position } from '../tictactoe/Position';

@Component({
  selector: 'tictactoe-square',
  templateUrl: './tictactoe-square.component.html',
  styleUrls: ['./tictactoe-square.component.css']
})
export class TictactoeSquareComponent implements OnInit {


  @Output() squareClickedEvent : EventEmitter<Position> = new EventEmitter<Position>();
  @Input() isX : number;
  @Input() row : number;
  @Input() col : number;

  imgSrc : string = "./assets/";

  constructor() { }

  ngOnInit(): void {

    if(this.isX === 0) 
      this.imgSrc = " ";
    else {
      if(this.isX === 1) 
        this.imgSrc += "x.jpeg";
      else if (this.isX === -1)
        this.imgSrc += "o.jpeg";
    }

  }

  squareClicked() : void {
    this.squareClickedEvent.emit(
      {
        row: this.row,
        col: this.col
      }
    );
  }

}
