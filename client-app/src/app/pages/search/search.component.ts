import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BlogService } from '../../services/blog.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {

  blogs: any[] = [];
  searchForm: FormGroup;
  term: string;

  constructor(
    private blogService: BlogService,
    private builder: FormBuilder,
  ) {

    this.searchForm = this.builder.group({
      term: ['', Validators.required]
    });

    this.term = '';
  }

  ngOnInit() {

  }



  search() {

    this.term = this.searchForm.value.term;
    if (this.term === '') {
      this.blogs = [];
    }
    else {

      this.blogService.search(this.term).subscribe(
        {
          next: response => {
            this.blogs = response;
          },
          error: err => {
            console.log(err);

          }
        });
    }
  }

}
