import { Component } from '@angular/core';
import { BlogService } from '../../services/blog.service';

@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrl: './blogs.component.css'
})
export class BlogsComponent {

  blogs: any[] = [];

  constructor(
    private blogService: BlogService
  ) { }

  ngOnInit() {
    this.blogService.all().subscribe({
      next: response => {
        this.blogs = response;
      },
      error: error => {
        console.log(error);
      }
    });
  }
}
