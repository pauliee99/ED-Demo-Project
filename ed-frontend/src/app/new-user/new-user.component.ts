import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '@entities/User';
import { UserServiceService } from '@services/user-service.service';

@Component({
  selector: 'app-new-user',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './new-user.component.html',
  styleUrl: './new-user.component.css'
})
export class NewUserComponent {
  user: User = {
    firstname: '',
    lastname: '',
    gender: 1,
    birthdate: '',
    workAddress: {
      street_name: '',
      street_num: 0,
      postal_code: 0,
    },
    homeAddress: {
      street_name: '',
      street_num: 0,
      postal_code: 0,
    },
  };

  constructor(private userService: UserServiceService) {}
  
  onSubmit() {
    this.userService.addUser(this.user).subscribe(response => {
      console.log("User created successfully!", response);
    });
  }
}
