import { InissanService } from "./interface";
import nissan from "../../models/nissan.model";


/**
 * @export
 * @implements {InissanModelService}
 */
const nissanService: InissanService = {
    /**
     * @returns {Promise < any[] >}
     * @memberof nissanFacade
     */
    async findAll(): Promise<any[]> {
        // Para enviar un mensaje a kafka
        // await Kafka.send("test", 'Hello');
        return nissan.findAll();
    }
}

export default nissanService;