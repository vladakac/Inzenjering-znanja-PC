import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-failure-cause',
  templateUrl: './failure-cause.component.html',
  styleUrls: ['./failure-cause.component.css']
})
export class FailureCauseComponent implements OnInit {
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
