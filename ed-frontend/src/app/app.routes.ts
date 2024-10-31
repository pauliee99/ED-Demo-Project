import { Routes } from '@angular/router';
import { UserListComponent } from './components/user-list/user-list.component';
import { NewUserComponent } from './components/new-user/new-user.component';
import { EditUserComponent } from './components/edit-user/edit-user.component';

export const routes: Routes = [
    { path: '', component: UserListComponent },
    { path: 'new-user', component: NewUserComponent },
    { path: 'edit-user', component: EditUserComponent }
];
