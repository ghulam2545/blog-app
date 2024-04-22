import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  signupForm: FormGroup;

  constructor(
    private builder: FormBuilder,
    private authService: AuthService
  ) {
    this.signupForm = this.builder.group({
      username: [null, Validators.required],
      email: [null, Validators.required, Validators.email],
      password: [null, Validators.required],
      confirmPassword: [null, Validators.required],
      intro: [null, Validators.required],
    });
  }

  onSubmit() {
    this.signup();
  }

  signup() {
    const { username, email, password, confirmPassword, intro } = this.signupForm.value;

    if (password !== confirmPassword) {
      alert('Password does not match');
      return;
    }

    this.authService.signup({ username, email, password, intro }).subscribe({
      next: response => {
        console.log(response);
      },
      error:
        err => {
          console.error(err);
        }
    });
  }

}