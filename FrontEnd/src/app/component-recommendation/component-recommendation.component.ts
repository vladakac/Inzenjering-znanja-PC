import { Component, OnInit } from '@angular/core';
import { ComponentRecommendationService } from '../services/component-recommendation.service';

@Component({
  selector: 'app-component-recommendation',
  templateUrl: './component-recommendation.component.html',
  styleUrls: ['./component-recommendation.component.css']
})
export class ComponentRecommendationComponent implements OnInit {
  Mobos : any[] = []
  CPUS : any[] = []
  GPUS : any[] = []
  RAMS : any[] = []
  PSUS : any[] = []
  mobo = ''
  cpu = ''
  gpu = ''
  ram = ''
  psu = ''
  comp : any[] = []

  constructor(private _compService : ComponentRecommendationService) { }

  ngOnInit(): void {
    this._compService.GetMobos().subscribe(res => this.Mobos = res)
    this._compService.GetCPUs().subscribe(res => this.CPUS = res)
    this._compService.GetGPUs().subscribe(res => this.GPUS = res)
    this._compService.GetRAMs().subscribe(res => this.RAMS = res)
    this._compService.GetPSUs().subscribe(res => this.PSUS = res)
  }

  Mobo(){
    var moboComp = {
      ramTitle : this.ram,
      cpuTitle : this.cpu
    }
    this._compService.GetCompMobo(moboComp).subscribe(res => {this.comp = res, console.log(res)})

  }

  CPU(){
    var cpuComp = {
      moboTitle : this.mobo
    }
    this._compService.GetCompCPU(cpuComp).subscribe(res => {this.comp = res, console.log(res)})
  }

  GPU(){
    var gpuComp = {
      psuTitle : this.psu
    }
    this._compService.GetCompGPU(gpuComp).subscribe(res => {this.comp = res, console.log(res)})
  }

  RAM(){
    var ramComp = {
      moboTitle : this.mobo
    }
    this._compService.GetCompRAM(ramComp).subscribe(res => {this.comp = res, console.log(res)})
  }

  PSU(){
    var psuComp = {
      gpuTitle : this.gpu
    }
    this._compService.GetCompPSU(psuComp).subscribe(res => {this.comp = res, console.log(res)})
  }
}
