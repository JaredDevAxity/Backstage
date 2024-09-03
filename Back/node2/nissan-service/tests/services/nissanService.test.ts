process.env.NODE_ENV = 'test'

import { expect } from "chai";
import { nissanService } from "../../src/services";
import { db } from '../../src/config/connection/database';
import nissan from "../../src/models/nissan.model";


describe('nissanService Test', () => {

  before('Init', async() => {
    await db.sync({ force: true});
    nissan.create({
      id: 1,
      name: 'test',
      createdAt: '2020-01-01',
      updatedAt: '2020-01-01'
    });
    nissan.create({
      id: 2,
      name: 'test2',
      createdAt: '2020-01-01',
      updatedAt: '2020-01-01'
    });

    //Para lanzar pruebas con kafka
    // let topics = [
    //   'pruebas',
    //   'test'
    // ];
    // try{
    //     await Kafka.init(topics);
    //     console.log('Connected to Kafka');

    // }catch(err){
    //     console.log('Error', err);
    // }
  });

  describe('FindAll', async() => {
    it('should return one user', async () => {
      const nissan: any[] = await nissanService.findAll();
      expect(2).equal(nissan.length);
    });
  });

});