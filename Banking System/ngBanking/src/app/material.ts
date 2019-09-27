import { NgModule } from "@angular/core";
import { MatCheckboxModule } from '@angular/material';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSnackBarModule } from '@angular/material/snack-bar';


@NgModule({
    imports: [MatButtonModule, MatCheckboxModule, MatToolbarModule, MatInputModule, MatIconModule, MatMenuModule, MatDialogModule, 
        MatSnackBarModule],
    exports: [MatButtonModule, MatCheckboxModule, MatToolbarModule, MatInputModule, MatIconModule, MatMenuModule, MatDialogModule, 
        MatSnackBarModule],
})

export class MaterialModule { }