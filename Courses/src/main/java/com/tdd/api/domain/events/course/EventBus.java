package com.tdd.api.domain.events.course;

import com.tdd.api.domain.DomainEntity;
import com.tdd.api.domain.events.DomainEntityToEventHandler;
import com.tdd.api.domain.events.DomainEvent;

public interface EventBus {
	<R extends DomainEntity, H extends DomainEntityToEventHandler> void register(Class<R> entity, H converter);

	<R extends DomainEntity, H extends DomainEvent> H dispatch(R entity);
}
