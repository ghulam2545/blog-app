import { Component } from '@angular/core';
import { BlogService } from '../../services/blog.service';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrl: './blog.component.css'
})
export class BlogComponent {

  public sanitizers: DomSanitizer;

  blog: any | '';
  id = this.router.snapshot.params['id'];

  constructor(
    private blogService: BlogService,
    private router: ActivatedRoute,
    private sanitizer: DomSanitizer
  ) {
    this.sanitizers = sanitizer;
  }

  ngOnInit() {
    this.read(this.id);
  }

  read(id: number) {
    this.blogService.read(id).subscribe({
      next: response => {
        this.blog = response;
      },
      error: error => {
        console.error(error);
      }
    });
  }


}
