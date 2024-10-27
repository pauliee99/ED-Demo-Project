import { Routes } from '@angular/router';
import { UserListComponent } from './components/user-list/user-list.component';
import { HeaderComponent } from './components/header/header.component';

export const routes: Routes = [
    { path: '', component: UserListComponent }
];