import { Component, OnInit } from '@angular/core';
import { ComponentRecommendationService } from '../services/component-recommendation.service';

@Component({
  selector: 'app-failure-cause',
  templateUrl: './failure-cause.component.html',
  styleUrls: ['./failure-cause.component.css']
})
export class FailureCauseComponent implements OnInit {
  symptoms : any
  causes : any
  selectedSymp : any = []
  selectedCauses : any = []
  results : any[] = []

  constructor(private _compService : ComponentRecommendationService) { }

  ngOnInit(): void {
    this._compService.GetSymptoms().subscribe(res => {this.symptoms = res})
    this._compService.GetCauses().subscribe(res => {this.causes = res})
  }

  Submit(){
    var body = {
      computerSymptomsList : this.selectedSymp,
      malfunctionCausesList : this.selectedCauses      
    }
    this._compService.Bayes(body).subscribe(res => {this.results = res, console.log(this.results)})
  }

}
