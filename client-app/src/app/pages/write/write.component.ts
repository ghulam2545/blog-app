import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BlogService } from '../../services/blog.service';

@Component({
  selector: 'app-write',
  templateUrl: './write.component.html',
  styleUrl: './write.component.css'
})
export class WriteComponent {

  editorStyle = {
    height: '350px'
  };

  writeForm: FormGroup;

  constructor(
    private builder: FormBuilder,
    private blogService: BlogService,
    private router: Router
  ) {
    this.writeForm = this.builder.group({
      title: [null, Validators.required],
      image: [null, Validators.required],
      category: [null, Validators.required],
      brief: [null, Validators.required],
      content: [null, Validators.required]
    });
  }

  onSubmit() {
    this.save();
    alert('Blog saved successfully');
    this.router.navigate(['/blogs']);
  }

  save() {
    this.blogService.save(this.writeForm.value).subscribe({
      next: response => {
        console.log(response);
      },
      error: error => {
        console.log(error);
      }
    });
  }
  
}
