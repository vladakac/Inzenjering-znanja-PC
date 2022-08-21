import { Component, OnInit } from '@angular/core';
import { ComponentRecommendationService } from '../services/component-recommendation.service';

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
  mobo = ''
  cpu = ''
  gpu = ''
  ram = ''
  hdd = ''

  constructor(private _compService : ComponentRecommendationService) { }

  ngOnInit(): void {
    this._compService.GetMobos().subscribe(res => this.Mobos)
    this._compService.GetCPUs().subscribe(res => this.CPUS)
    this._compService.GetGPUs().subscribe(res => this.GPUS)
    this._compService.GetRAMs().subscribe(res => this.RAMS)
    this._compService.GetHDDs().subscribe(res => this.HDDS)
  }

  Submit(){
    console.log(this.mobo)
  }

}
