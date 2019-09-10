package org.firefly.provider.unit.test.runner.theory;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(Between.BetweenSupplier.class)
public @interface Between {
    int first() default 0;

    int last();

    class BetweenSupplier extends ParameterSupplier {
        @Override
        public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
            Between between = sig.getAnnotation(Between.class);
            int first = between.first();
            int last = between.last();

            List<PotentialAssignment> list = new ArrayList<>();
            for (int i = first; i <= last; i++) {
                list.add(PotentialAssignment.forValue("name", i));
            }
            return list;
        }
    }
}
