import { Component } from '@angular/core';
import { MaterialModule } from '../../shared/material-module';
import { CartItemComponent } from './cart-item/cart-item.component';
import { AddressCardComponent } from './address-card/address-card.component';
import {
  MatDialog,
  MatDialogConfig,
  MatDialogContent,
  MatDialogTitle,
} from '@angular/material/dialog';
import { AddressDialogComponent } from './address-dialog/address-dialog.component';
import { Router } from '@angular/router';
import { title } from 'process';

export interface DialogData {
  animal: 'panda' | 'unicorn' | 'lion';
}

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [MaterialModule, CartItemComponent, AddressCardComponent],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.scss',
})
export class CartComponent {
  constructor(public dialog: MatDialog, private router: Router) {}

  
  
  openDialog = () => {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.panelClass = 'address-dialog.component';
    dialogConfig.data = {
      title: 'Add New Address',
      action: 'Add',
    };
    dialogConfig.width = '300px';
    dialogConfig.height = 'auto';

    let dialogRef = this.dialog.open(AddressDialogComponent, dialogConfig);

    dialogRef.afterOpened().subscribe(() => {
      const routerSub = this.router.events.subscribe(() => {
        dialogRef.close();
        routerSub.unsubscribe();
      });
      const subs = dialogRef.componentInstance['onAddAddress'].subscribe(() => {
        dialogRef.afterClosed().subscribe(() => {
          this.getUserAddress();
          subs.unsubscribe();
        });
      });
    });
  };

  getUserAddress = () => {
    console.log('Address');
  };
}
