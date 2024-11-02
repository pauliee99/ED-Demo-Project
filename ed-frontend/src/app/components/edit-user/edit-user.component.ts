import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { User } from '@entities/User';
import { UserServiceService } from '@services/user-service.service';

@Component({
  selector: 'app-edit-user',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-user.component.html',
  styleUrl: './edit-user.component.css'
})
export class EditUserComponent {
  user: User = { 
    id: 0, 
    firstname: '', 
    lastname: '', 
    gender: 0, 
    birthdate: '', 
    workAddress: { street_name: '', street_num: 0, postal_code: 0 },
    homeAddress: { street_name: '', street_num: 0, postal_code: 0 }
  };

  constructor(private userService: UserServiceService, private route: ActivatedRoute,) {}

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.userService.getUserById(id).subscribe(response => {
      console.log("User returned successfully!", response);
      this.user = response;
    })
  }
  
  onSubmit() {
    this.userService.addUser(this.user).subscribe(response => {
      console.log("User created successfully!", response);
    });
  }
}
