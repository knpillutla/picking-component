CREATE TABLE picks
(
    ID serial  primary key,
	LOCN_NBR integer not null default 0,
	BUS_UNIT  character varying(3) COLLATE pg_catalog.default NOT NULL,
    LOCN_BRCD character varying(25) COLLATE pg_catalog.default NOT NULL,
    ITEM_BRCD character varying(25) COLLATE pg_catalog.default NOT NULL,
    TOTAL_PICK_QTY integer NOT NULL DEFAULT 0,
    TOTAL_PICKED_QTY integer DEFAULT 0,
    FROM_CONTAINER_NBR  character varying(25),
    TO_CONTAINER_NBR  character varying(25),
	PICK_TYPE character varying(50),
    STAT_CODE integer DEFAULT 0,
	WAVE_NBR character varying(50),
	ORDER_NBR  character varying(50),
	PACKAGE_NBR  character varying(50),
	SOURCE character varying(50),
	HOST_NAME  character varying(50),
    CREATED_DTTM  timestamp default NOW(),
    UPDATED_DTTM  timestamp default NOW(),
    USER_ID character varying(25)
);