import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-similarity-check',
  templateUrl: './similarity-check.component.html',
  styleUrls: ['./similarity-check.component.css']
})
export class SimilarityCheckComponent implements OnInit {
  Mobos : any[] = ["1", "2"]
  CPUS : any[] = ["1", "2"]
  GPUS : any[] = ["1", "2"]
  RAMS : any[] = ["1", "2"]
  HDDS : any[] = ["1", "2"]
  mobo = ''
  cpu = ''
  gpu = ''
  ram = ''
  hdd = ''

  constructor() { }

  ngOnInit(): void {
  }

  Submit(){
    console.log(this.mobo)
  }

}
