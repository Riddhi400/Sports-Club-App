import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';   // ✅ Import this

interface Event {
  name: string;
  date: string;
  location: string;
  description: string;
}

@Component({
  selector: 'app-events',
  standalone: true,
  imports: [FormsModule, CommonModule],   // ✅ Add here
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent {
  events: Event[] = [
    { name: 'Football Tournament', date: '2025-09-01', location: 'Main Ground', description: 'Annual Football Tournament' }
  ];

  newEvent: Event = { name: '', date: '', location: '', description: '' };

  addEvent() {
    if (this.newEvent.name && this.newEvent.date) {
      this.events.push({ ...this.newEvent });
      this.newEvent = { name: '', date: '', location: '', description: '' };
    }
  }

  deleteEvent(index: number) {
    this.events.splice(index, 1);
  }
}