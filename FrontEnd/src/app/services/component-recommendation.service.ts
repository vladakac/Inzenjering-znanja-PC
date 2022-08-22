import { HttpClient } from '@angular/common/http';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ComponentRecommendationService {
  private _APIUrl = "http://localhost:8080/api/";

  constructor(private _httpClient: HttpClient) { }

  GetMobos(){
    return this._httpClient.get<any[]>(this._APIUrl + 'Motherboard')
  }
  
  GetCPUs(){
    return this._httpClient.get<any[]>(this._APIUrl + 'CPU')
  }

  GetGPUs(){
    return this._httpClient.get<any[]>(this._APIUrl + 'GPU')
  }

  GetRAMs(){
    return this._httpClient.get<any[]>(this._APIUrl + 'RAM')
  }

  GetHDDs(){
    return this._httpClient.get<any[]>(this._APIUrl + 'HDD')
  }

  GetSSDs(){
    return this._httpClient.get<any[]>(this._APIUrl + 'SSD')
  }

  GetPSUs(){
    return this._httpClient.get<any[]>(this._APIUrl + 'PSU')
  }

  FuzzyCheck(body : any){
    return this._httpClient.put<any[]>(this._APIUrl + 'fuzzy', body)
  }
  
  FindSimilar(body : any){
    return this._httpClient.put<any[]>(this._APIUrl + 'cbr', body)
  }

  GetSymptoms() {
    return this._httpClient.get<any[]>(this._APIUrl + 'bayes/symptoms')
  }

  GetCauses() {
    return this._httpClient.get<any[]>(this._APIUrl + 'bayes/causes')
  }

  Bayes(body : any){
    return this._httpClient.post<any[]>(this._APIUrl +'bayes', body)
  }

  GetCompMobo(body : any){
    return this._httpClient.post<any[]>(this._APIUrl + 'Motherboard/compatible', body)
  }

  GetCompCPU(body : any){
    return this._httpClient.post<any[]>(this._APIUrl + 'CPU/compatible', body)
  }

  GetCompGPU(body : any){
    return this._httpClient.post<any[]>(this._APIUrl + 'GPU/compatible', body)
  }

  GetCompRAM(body : any){
    return this._httpClient.post<any[]>(this._APIUrl + 'RAM/compatible', body)
  }

  GetCompPSU(body : any){
    return this._httpClient.post<any[]>(this._APIUrl + 'PSU/compatible', body)
  }
}
