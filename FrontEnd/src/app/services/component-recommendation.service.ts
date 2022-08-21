import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ComponentRecommendationService {
  private _APIUrl = "https://localhost:****/api/";

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
}
