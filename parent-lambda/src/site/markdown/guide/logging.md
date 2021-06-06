<!---
# This file is part of the pl.wrzasq.parent.
#
# @license http://mit-license.org/ The MIT license
# @copyright 2020 - 2021 © by Rafał Wrzeszcz - Wrzasq.pl.
-->

Including this dependency in a **Lambda** project establishes a standard logging facility based on **SLF4J** (not that
it also wraps **log4j**, which means also AWS SDK classes logs and others will be handled).

Standard logging format generates following output format:

```
[main] INFO  pl.wrzasq.lambda.macro.lambda.function.template.ProcessedTemplate - Creating resources for MultistageCdMacroLambda.
```

This allows for creating filters and alerts in **CloudWatch** based on message types, like:

```yaml
Resources:
    PipelineProjectMacroLambdaErrorsMetricFilter:
        Type: "AWS::Logs::MetricFilter"
        Properties:
            MetricTransformations:
                -
                    MetricValue: "1"
                    MetricNamespace: "WrzasqPl/Lambda"
                    MetricName: !Sub "${YourLambda}-Errors"
            FilterPattern: "ERROR -LOG_ERROR"
            LogGroupName: !Ref "YourLambdaLogGroup"
```

## Tracing

Additionally, also **X-Ray** instrumentor is included which makes all of AWS clients automatically instrumented for
tracing.
