import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

interface Member {
  name: string;
  email: string;
  phone: string;
}

@Component({
  selector: 'app-members',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.css']
})
export class MembersComponent {
  members: Member[] = [
    { name: 'Riddhi Bhojane', email: 'riddhi@gmail.com', phone: '1234567890' }
  ];

  newMember: Member = { name: '', email: '', phone: '' };

  addMember() {
    if (this.newMember.name && this.newMember.email) {
      this.members.push({ ...this.newMember });
      this.newMember = { name: '', email: '', phone: '' };
    }
  }

  deleteMember(index: number) {
    this.members.splice(index, 1);
  }
}