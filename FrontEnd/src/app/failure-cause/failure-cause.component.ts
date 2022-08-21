import { Component, OnInit } from '@angular/core';
import { ComponentRecommendationService } from '../services/component-recommendation.service';

@Component({
  selector: 'app-failure-cause',
  templateUrl: './failure-cause.component.html',
  styleUrls: ['./failure-cause.component.css']
})
export class FailureCauseComponent implements OnInit {
  Mobos : any[] = []
  CPUS : any[] = []
  GPUS : any[] = []
  RAMS : any[] = []
  HDDS : any[] = []
  mobo = ''
  cpu = ''
  gpu = ''
  ram = ''
  hdd = ''

  constructor(private _compService : ComponentRecommendationService) { }

  ngOnInit(): void {
    this._compService.GetMobos().subscribe(res => this.Mobos = res)
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

  }

}
