package practice.test4;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		/*
		���� 1.
		BiPredicate
		BinaryOperator
		IntConsumer
		IntFunction
		IntPredicate
		IntUnaryOperator
		IntBinaryOperator
		IntToDoubleFunction
		ToIntFunction
		ToIntBiFunction
		�� �Լ��� �������̽����� �̿��� ���ٽ��� �ۼ��ϰ� ����ϼ���. 
		*/
		
		System.out.println("--BiPredicate--");
		BiPredicate<Integer, String> bp = (i, str) -> Integer.parseInt(str) + i <= 10;
		System.out.println(bp.test(8, "2"));
	
		System.out.println("--BinaryOperator--");
		BinaryOperator<String> bo = (str1, str2) -> str1 + str2;
		System.out.println(bo.apply("��", "��ǻ��"));
		System.out.println();
		
		System.out.println("--IntConsumer--");
		IntConsumer intConsumer = i -> System.out.println(i * 0.1);
		intConsumer.accept(7);
		System.out.println();
		
		System.out.println("--IntFunction--");
		IntFunction<Integer> intFunction = i -> (i * 10);
		System.out.println(intFunction.apply(1000));
		System.out.println();
		
		System.out.println("--IntPredicate--");
		IntPredicate intPredicate = i -> i < 10;
		System.out.println(intPredicate.test(100));
		System.out.println();
		
		System.out.println("--intUnaryOperator--");
		IntUnaryOperator intUnaryOperator = i -> (int)(i *0.1f);
		System.out.println(intUnaryOperator.applyAsInt(10000));
		System.out.println();
		
		System.out.println("--IntBinaryOperator--");
		IntBinaryOperator ibo = (i, i2) -> (int)(i * i2);
		System.out.println(ibo.applyAsInt(1000, 10));
		System.out.println();
		
		System.out.println("--IntToDoubleFunction--");
		IntToDoubleFunction iToD = (i) -> (int)(i * 1000);
		System.out.println(iToD.applyAsDouble(10));
		System.out.println();
		
		System.out.println("--ToIntFunction--");
		ToIntFunction<String> toIntFunction = str -> Integer.parseInt(str) *100;
		System.out.println(toIntFunction.applyAsInt("100"));
		System.out.println();
		
		System.out.println("--ToIntBiFunction--");
		ToIntBiFunction<Integer, String> toIntBiFunction = (i, str) -> i * Integer.parseInt(str) *100;
		System.out.println(toIntBiFunction.applyAsInt(10, "10"));
	}

}
