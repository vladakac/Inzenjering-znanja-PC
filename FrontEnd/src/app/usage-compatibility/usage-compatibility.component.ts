import { Component, OnInit } from '@angular/core';
import { ComponentRecommendationService } from '../services/component-recommendation.service';

@Component({
  selector: 'app-usage-compatibility',
  templateUrl: './usage-compatibility.component.html',
  styleUrls: ['./usage-compatibility.component.css']
})
export class UsageCompatibilityComponent implements OnInit {
  CPUS : any[] = []
  GPUS : any[] = []
  RAMS : any[] = []
  HDDS : any[] = []
  cpu = ''
  gpu = ''
  ram = ''
  hdd = ''
  fuzzy : any = {}



  constructor(private _compService : ComponentRecommendationService) { }

  ngOnInit(): void {
    this._compService.GetCPUs().subscribe(res => this.CPUS = res)
    this._compService.GetGPUs().subscribe(res => this.GPUS = res)
    this._compService.GetRAMs().subscribe(res => this.RAMS = res)
    this._compService.GetHDDs().subscribe(res => this.HDDS = res)
  }

  Submit(){
    var body = {
      ramTitle : this.ram,
      cpuTitle : this.cpu,
      gpuTitle : this.gpu,
      diskTitle : this.hdd
    }
    this._compService.FuzzyCheck(body).subscribe(res => this.fuzzy = res)
  }

}
