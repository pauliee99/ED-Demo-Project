import { Address } from "./Address";

export interface User {
    id?: number;
    firstname: string;
    lastname: string;
    gender: number;
    birthdate: string;
    workAddress: Address;
    homeAddress: Address;
  }