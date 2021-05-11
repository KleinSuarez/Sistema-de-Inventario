package co.software.apiinventory.command.handler.product.modification;

import co.software.apiinventory.aplication.CommandResponse;
import co.software.apiinventory.aplication.handle.HandlerCommandResponse;
import co.software.apiinventory.command.converter.product.ProductConverter;
import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.service.product.modification.ProductModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductModificationHandler implements HandlerCommandResponse<ProductDTO, CommandResponse<Integer>> {

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ProductModificationService productModificationService;

    @Override
    public CommandResponse<Integer> execute(ProductDTO productDTO) {
        return new CommandResponse<Integer>(productModificationService.update(productDTO.getIdProduct(), productConverter.update(productDTO)));
    }

    public CommandResponse<Integer> execute (ProductDTO productDTO, Integer instock, Integer outstock){
        return new CommandResponse<Integer>(productModificationService.updateStock(productDTO.getIdProduct(), productConverter.update(productDTO), instock, outstock));
    }
}
