import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

interface Payment {
  member: string;
  amount: number;
  date: string;
}

@Component({
  selector: 'app-payments',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})
export class PaymentsComponent {
  payments: Payment[] = [
    { member: 'Riddhi Bhojane', amount: 50, date: '2025-08-15' }
  ];

  newPayment: Payment = { member: '', amount: 0, date: '' };

  addPayment() {
    if (this.newPayment.member && this.newPayment.amount > 0) {
      this.payments.push({ ...this.newPayment });
      this.newPayment = { member: '', amount: 0, date: '' };
    }
  }

  deletePayment(index: number) {
    this.payments.splice(index, 1);
  }
}