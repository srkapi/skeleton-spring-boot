package com.srkapi.base.application.fibonacci;

import com.srkapi.base.application.fibonacci.command.FibonacciCommand;
import com.srkapi.base.application.fibonacci.command.FibonacciCommandResult;
import com.srkapi.base.application.fibonacci.usecase.CalculateFibonacciUseCases;
import com.srkapi.base.domain.fibonacci.domain.exceptions.NumberErrorException;
import com.srkapi.base.shared.DomainException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FibonacciCalculator implements CalculateFibonacciUseCases {

    @Override
    public FibonacciCommandResult execute(FibonacciCommand fibonacciRequestCommand) throws DomainException {
        if (fibonacciRequestCommand.getNum() <= 0) throw new NumberErrorException("value is negative");
        int result = calculate(fibonacciRequestCommand.getNum());
        return new FibonacciCommandResult(result);
    }

    private int calculate(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return calculate(n - 1) + calculate(n - 2);
    }
}