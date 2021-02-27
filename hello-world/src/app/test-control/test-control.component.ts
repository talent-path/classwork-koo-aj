import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test-control',
  templateUrl: './test-control.component.html',
  styleUrls: ['./test-control.component.css']
})
export class TestControlComponent implements OnInit {


  constructor() { }

  ngOnInit(): void {
  }

  flag: boolean = false;
  imgSrc: string = "./assets/cats.png";
  onClick(): void {
    this.flag ? this.imgSrc = "./assets/cats.png" : this.imgSrc = "./assets/dogs.jpg";
    this.flag = !this.flag;
  }
}
