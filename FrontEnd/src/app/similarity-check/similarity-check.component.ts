import { Component, OnInit } from '@angular/core';
import { ComponentRecommendationService } from '../services/component-recommendation.service';

@Component({
  selector: 'app-similarity-check',
  templateUrl: './similarity-check.component.html',
  styleUrls: ['./similarity-check.component.css']
})
export class SimilarityCheckComponent implements OnInit {
  Mobos : any[] = []
  CPUS : any[] = []
  GPUS : any[] = []
  RAMS : any[] = []
  HDDS : any[] = []
  SSDS : any[] = []
  mobo = ''
  cpu = ''
  gpu = ''
  ram = ''
  hdd = ''
  ssd = ''
  PCs : any[] = []


  constructor(private _compService : ComponentRecommendationService) { }

  ngOnInit(): void {
    this._compService.GetMobos().subscribe(res => this.Mobos = res)
    this._compService.GetCPUs().subscribe(res => this.CPUS = res)
    this._compService.GetGPUs().subscribe(res => this.GPUS = res)
    this._compService.GetRAMs().subscribe(res => this.RAMS = res)
    this._compService.GetHDDs().subscribe(res => this.HDDS = res)
    this._compService.GetSSDs().subscribe(res => this.SSDS = res)
  }

  Submit(){
    var body = {
      cpuTitle : this.cpu,
      gpuTitle : this.gpu,
      hddTitle : this.hdd,
      moboTitle : this.mobo,
      ramTitle : this.ram,
      ssdTitle : this.ssd
    }
    this._compService.FindSimilar(body).subscribe(res => this.PCs = res)
  }

}
