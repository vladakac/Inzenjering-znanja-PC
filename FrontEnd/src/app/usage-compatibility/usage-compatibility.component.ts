import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-usage-compatibility',
  templateUrl: './usage-compatibility.component.html',
  styleUrls: ['./usage-compatibility.component.css']
})
export class UsageCompatibilityComponent implements OnInit {
  Mobos : any[] = ["1", "2"]
  CPUS : any[] = ["1", "2"]
  GPUS : any[] = ["1", "2"]
  RAMS : any[] = ["1", "2"]
  HDDS : any[] = ["1", "2"]

  constructor() { }

  ngOnInit(): void {
  }

  Submit(){
  }

  gpuSelect(GPU: any){
    console.log(GPU)
  }

}
