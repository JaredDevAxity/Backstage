import { nissanService } from "../../services";
import { InissanFacade } from "./interface";


/**
 * @export
 * @implements {InissanModelService}
 */
const nissanFacade: InissanFacade = {
    /**
     * @returns {Promise < any[] >}
     * @memberof nissanFacade
     */
    async findAll(): Promise<any[]> {

        let nissan = await nissanService.findAll();
        return nissan;
    }
}

export default nissanFacade;