package co.software.apiinventory.command.handler.product.insert;

import co.software.apiinventory.aplication.CommandResponse;
import co.software.apiinventory.aplication.handle.HandlerCommandResponse;
import co.software.apiinventory.command.converter.product.ProductConverter;
import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.service.product.insertion.ProductInsertionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductInsertHandler implements HandlerCommandResponse <ProductDTO, CommandResponse<Integer>> {

    @Autowired
    private ProductInsertionService productInsertionService;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public CommandResponse<Integer> execute(ProductDTO productDTO) {
        return new CommandResponse<Integer>(productInsertionService.InsertProduct(productConverter.insert(productDTO)));
    }
}
