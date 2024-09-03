process.env.NODE_ENV = 'test'

import { expect } from "chai";
import nissanFacade from '../../src/facade/nissan/facade';
import { db } from '../../src/config/connection/database';
import nissan from "../../src/models/nissan.model";


describe('nissanFacade Test', () => {

    before('Init', async() => {
        await db.sync({ force: true});
        nissan.create({
        id: 1,
        name: 'test',
        createdAt: '2020-01-01',
        updatedAt: '2020-01-01'
        });

        //Para lanzar pruebas con kafka
        // let topics = [
        //     'pruebas',
        //     'test'
        // ];
        // try{
        //     await Kafka.init(topics);
        //     console.log('Connected to Kafka');

        // }catch(err){
        //     console.log('Error', err);
        // }
    });
  
    describe('FindAll', () => {
        it('should return one user', async () => {
            const nissan: any[] = await nissanFacade.findAll();
            expect(1).equal(nissan.length);
        });
    });
});